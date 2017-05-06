--------------------------使用properties文件：
server.port=8090  
server.session-timeout=30  
server.context-path=  
server.tomcat.max-threads=0  
server.tomcat.uri-encoding=UTF-8  
  
spring.datasource.url = jdbc:mysql://localhost:3306/newbirds  
spring.datasource.username = root  
spring.datasource.password = mymysql  
spring.datasource.driverClassName = com.mysql.jdbc.Driver  
# Specify the DBMS  
spring.jpa.database = MYSQL  
# Show or not log for each sql query  
spring.jpa.show-sql = true  
# Hibernate ddl auto (create, create-drop, update)  
spring.jpa.hibernate.ddl-auto = update  
# Naming strategy  
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy  
  
# stripped before adding them to the entity manager)  
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect  

------------------------------使用yml文件：

server:  
  port: 8090 
  session-timeout: 30  
  tomcat.max-threads: 0  
  tomcat.uri-encoding: UTF-8  
  
spring:
  datasource:  
    url: jdbc:mysql://localhost:3306/springboot  
    username: root  
    password: root
    driverClassName: com.mysql.jdbc.Driver
    max-active: 20
    max-idle: 8
    min-idle: 8
    initial: 10
  jpa:  
    database: MYSQL  
    show-sql: true
    hibernate:  
      ddl-auto: create
      format-sql: true  
      naming-strategy: org.hibernate.cfg.ImprovedNamingStrategy  
    properties:  
      hibernate:  
        dialect: org.hibernate.dialect.MySQLDialect
        #dialect: org.hibernate.dialect.MySQL5Dialect 
        
        
        
        
-------------------------SPringData JPA
双向一对多关系，一是关系维护端（owner side），多是关系被维护端（inverse side）。在关系被维护端需要通过@JoinColumn建立外键列指向关系维护端的主键列。

 
 
publicclass Order implements Serializable {
    privateSet<OrderItem> orderItems = new HashSet<OrderItem>();
         。。。。
    @OneToMany(mappedBy="order",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    public Set<OrderItem> getOrderItems() {
        returnorderItems;
     }
}
 
publicclass OrderItem implements Serializable {
private Order order;
。。。。
    @ManyToOne(cascade=CascadeType.REFRESH,optional=false)
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        returnorder;
     }
}
@OrderBy(value = "id ASC") 指明加载OrderItem 时按id 的升序排序
 
@OneToMany的属性：
1>targetEntity
定义关系类的类型，默认是该成员属性对应的类类型，所以通常不需要提供定义。
 
2>mappedBy
定义类之间的双向关系。如果类之间是单向关系，不需要提供定义，如果类和类之间形成双向关系，我们就需要使用这个属性进行定义，否则可能引起数据一致性的问题。
该属性的值是“多”方class里的“一”方的变量名
 
3>cascade
该属性定义类和类之间的级联关系。定义的级联关系将被容器视为对当前类对象及其关联类对象采取相同的操作，而且这种关系是递归调用的。举个例子：Order 和OrderItem有级联关系，那么删除Order时将同时删除它所对应的OrderItem对象。而如果OrderItem还和其他的对象之间有级联关系，那么这样的操作会一直递归执行下去。
 
cascade的值只能从CascadeType.PERSIST（级联新建）、CascadeType.REMOVE（级联删除）、CascadeType.REFRESH（级联刷新）、CascadeType.MERGE（级联更新）中选择一个或多个。还有一个选择是使用CascadeType.ALL，表示选择全部四项。
 
4>fatch
可选择项包括：FetchType.EAGER和FetchType.LAZY。前者表示关系类(本例是OrderItem 类)在主类(本例是Order类)加载的时候同时加载，后者表示关系类在被访问时才加载。默认值是FetchType.LAZY。
 
@JoinColumn(name = "order_id")注释指定OrderItem映射表的order_id列作为外键与Order 映射表的主键列关联。
 
@ManyToOne：指明OrderItem和Order之间为多对一关系。
 
@ManyToOne注释有四个属性：targetEntity、cascade、fetch 和optional，前三个属性的具体含义和@OneToMany的同名属性相同，但@ManyToOne的fetch 属性默认值是FetchType.EAGER。
 
optional属性是定义该关联类是否必须存在，值为false 时，关联类双方都必须存在，如果关系被维护端不存在，查询的结果为null。值为true 时, 关系被维护端可以不存在，查询的结果仍然会返回关系维护端，在关系维护端中指向关系被维护端的属性为null。optional属性的默认值是true。optional 属性实际上指定关联类与被关联类的join 查询关系，如optional=false 时join 查询关系为inner join, optional=true 时join 查询关系为left join。下面代码片断解释如下:
 
 
 
 
 
有一点需要强调：当业务方法需要把一个实体Bean作为参数返回给客户端时，除了实体Bean本身需要实现Serializable 接口之外，如果关联类(OrderItem)是延迟加载，还需在返回实体Bean之前通过访问关联类的方式加载关联类（见下例）。否则在客户端访问关联类时将会抛出加载例外。
    public Order getOrderByID(Integer orderid) {
        Order order = em.find(Order.class, orderid);        
       //!!!!!因为是延迟加载，通过执行size()这种方式获取订单下的所有订单项
        order.getOrderItems().size();
       return order;
     }
 
另外不管是否延迟加载，通过join fetch 关联语句都可显式加载关联类，如下例：
 
    public List getAllOrder() {
         Query query = em.createQuery("select DISTINCT o from Order o inner
join fetch o.orderItems order by o.orderid");
         List result = query.getResultList();
        return result;
     }