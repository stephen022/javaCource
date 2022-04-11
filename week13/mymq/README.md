本题实现的是版本二，去掉内存Queue， 设计自定义Queue， 实现消息确认和消费offset
1） 自定义内存Message数组模拟Queue。
2） 使用指针记录当前消息写入位置。
3） 对于每个命名消费者， 用指针记录消费位置。  

设计思路：

一：对Kmq的改造

1）有关数组的部分

1.  使用数组，数组类型KmqMessage[]，而且不进行数组扩展的操作，当数组存满后，不能保存，即保存失败。
2. 保存到数组的消息，不进行删除，即没有清除策略的使用，也就不会使用环形数组。

2）使用指针记录当前消息写入位置。

使用两个下标的指针：

currentWriteIndex ： 这个是指向当前可写的下标，初始值为0，即从小标为0的位置开始写，最大写到下标为数组length-1的位置。

currentCanReadMaxIndex ：这个指向当前可以读到的消息最大下标位置。

这两个下标指针的关系是，在每次事务性操作过程的前后都必须保持这个等式成立：

3）对于每个命名消费者， 用指针记录消费位置

使用ConcurrentHashMap<String, AtomicInteger>，来保存每个命名消费者，和其目前应读取信息的偏移量。

为了能保存这个对应关系，在Kmq中添加了一个方法registerConsumer(String consumerId)。当消费者订阅某个主题（topic）时，生成一个UUID字符串作为自己的标识，然后注册到这个主题的Kmq实例中，在Kmq实例中，设置初始偏移量为0，并将消费者标识和初始偏移量保存这个map中。


二：对KmqProducer的改造

对KmqProducer的改造，主要是围绕在事务这个方面。

1. 增加一个boolean类型的属性autoCommit，指明是否在发消息时自动进行提交，为false时必须和事务方法配合使用，或者说使用事务方法时，必须先调用setAutoCommit(false)。调用setAutoCommit(true)后，不需要在使用事务方法，直接调用send方法。
2. send方法中根据当前属性autoCommit值，调用Kmq的send方法或sendWithoutLock方法
3. 增加三个方法beginTransaction(String topic)、commitTransaction(String topic)、abortTransaction(String topic)方法，这个就是对Kmq的三个事务方法的包装。

三：对KmqConsumer的改造

对KmqConsumer的改造主要围绕在consumer在读取数据时需要保留各自的读取的offset，因此需要在订阅主题时给相应的Kmq实例注册consumer标识，在拉取信息将自己的标识传过去。


测试结果，可以看见发的1000条信息正常接收。