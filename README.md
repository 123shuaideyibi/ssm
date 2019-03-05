
# ssm
ssm整合框架

这里重点说一下，这个项目是能够成功运行的，不是半成品的（自己构建的）
该框架目前已经实现了登录注册的功能，仅仅是简单的框架

如果过使用该框架，只需要注意一下几点

1、打开设置将jdk换成你自己电脑安装的jdk
2、maven重新设置换成自己电脑安装的maven
3、如果需要更换项目名，打开project structure更换项目名，然后关闭项目，修改这个项目文件夹的名字
（以上是我能想到的，还需要修改哪些，如果想到了会在这里说明的）

下面是我对这个框架整体的介绍，在这里我只会说明那个文件或者文件夹起的什么作用，不会说明具体说明代码的细节

等我学会长截图在想象这么复制上来（如果不行，后期我也会补上），目前我就直接将项目说明一下

登录和注册实现的流程图：很清晰掌握ssm框架的流程：
流程图
login.jsp->UserController.class->UserService.interface（<-->UserServiceImpl.class）->UserMapper.interface->Usermapper.xml->mysql数据库
...->UserController.class->loginSccess.jsp(或者error.jsp)

这是数据去mysql的过程，数据就是反过来的，需要说明<-->这是一去一回，因为service是一个接口（不懂接口百度，直到懂为止），可能你们会说这样省略总觉得
跟具体有差异，但是实际就是这样，比如你通过在mysql语句中select一条语句，但是select这个本身就是一来一回的的语句，根本就不存在单向的语句，所有要么查询
失败没有方向，要么就是双向的，这也是打省略的原因，are you 懂？


流程了解完后，接下来就是具体的架构
ssm
  -.idea
  -log  
  -src  
    -main 
（标记为源码）    -java     需要标记为测试源 根
      -com    
        -atgongda     com.gongda是我的项目组名，如果有需要换别的名字直接更改，然后所有与名字有关的文件说明的就能自动更新，这点也是我比较佩服idea的地方
          -controller   控制层 位于jsp和service之间
            -UserController.class  具体控制代码，登录和注册的控制都写在了里面
          -dao dao层，这里只是一个接口，功能是与与数据库交互，接受service的数据然后将得到的数据返回给service（记住增删改查都可以有返回，不只是查询，
                增删改可以是boolean或int等，并不是硬性的规定为void，当然string不行）
             -Usermapper.interface 具体的用户接口，注意是接口，他不会具体处理什么数据，仅仅只是接口而已
          -entity 实体类
             -User.class 用户实体类
           -service service层，主要处理业务逻辑(什么叫业务逻辑？controller只负责提要求，dao只负责查数据，而它是来对这些要求和数据进行加工的)
              -UserService.class
            servlet 上下文（正常本该只有四层，为什么出现了我？我是谁，我是上下文，啥是上下文，相信很多人不知道，login.jsp里面有具体代码我直接复制
                          过来 action="${ctx}/user/login" 没有上下文行不行，当然可以，可以写成/user/login 也可以写成user/login，看上去也可以运行
                          成功，但是有时候不行，但是写了我的话不管加不加斜杠绝逼没问题，这里的代码什么意思，我也不知道，你只需要直接copy过来，然后
                          使用的时候前面加上${ctx}就ok）
              -WebPathInitServlet
        （标记为resources）    -resources
                -mapper
                      -UserMapper.xml   与mysql数据库直接交互，相当于json的功能，流程图里面的entity没说，那是因为User.class和int其实是可以理
                                         解为一种类型，完全没有必要再流程图里面出现，你直接把他当做int，string这些就行，所以我不划入流程图当中
                -spring
                      -spring-dao               spring和mybatis的整合
                      -spring-mvc               springmvc的相关配置
                      -spring-service          spring和service整合（别人的代码里面可能是spring-mybatis和spring-mvc就ok,我这么写是有原因的，
                                              下 面我 在继续说明为什么要写成三个）
                 -jdbc.properties  里面是连接数据库的数据，驱动，数据库用户名，密码什么的，spring-dao才是连接数据库的配置，他只是被调用而已，提醒一
                                  下jdbc.url后面的都要加上，可能别人代码里面没写，但是我曾在编写测试类的时候因为出现乱码、没证书的错误，所以，
                                  必须加上，也是经验所得
                 -logback.xml   日志，主要是控制台的日志，还在使用log4j.properties等的都是弟弟，直接复制我这个，里面只需要修改日志文件的位置就ok,
                               当然log4j的依赖还是要添加，这里既然说到那就说一下pom.xml，你直接导入我导入我全部的，如果不够的上
                               https://mvnrepository.com/这个地址添加
                 -mybatis.config.xml   这个文件里面的配置写mybatis的配置文件，其实它也可以直接写在spring-dao里面，为什么要单独拎出来，主要为了
                                       减轻spring和mybatis除了整合还要关心mybatis单独配置的负担
                                       
                 webapp
                        -css  样式，没什么好讲的，jsp需要什么样式，这里写好，那边直接引用就行，减轻jsp除了展示页面还要写化妆的作用
                        -js   脚本，跟css一样,jsp引用
                        jsp  一部分代码，登录或者注册成功后会进入这里表示俺成功了，另一部分跟index一块儿
                        static    放插件
                            custom  自定义插件
                            plugins   下载的插件，如jquery，layui前端框架需要的插件等
                         web-inf
                              web.xml     最核心的地方，前面各种配置，不到这来设置一下都没什么卵用
                         index.jsp  主要跳转两个地方，登录页面和注册页面
                         login.jsp   就是你想的那个登录页面
                         register.jsp   就是你想的那个注册页面
                         
                test
                上面不是说为什么要拆分为将spring-mybatis.xml划分为spring-dao.xml和spring-service.xml吗
                    (标记为测试类)java
                          dao
                                DaoTest.class  测试方法->UserMapper.interface->UserMapper.xml->mysql
                           service
                                 Service.class 测试方法->UserService.interface(UserServiceImpl.class)->UserMapper.interface->UserMapper.xml
                                                ->mysql
                    为什么会出现这样的测试类？
                    这对后面做程序有很大的帮助
                    从jsp到mysql数据库之间有很多关，如果一次成功当然是好的，但是如果报错就很难发现是哪一步报错，毕竟你不是神，
                    dao测试：dao测试类->dao层->mysql数据库
                    service测试：service测试类->service层->dao层->数据库
                    controller测试：controller层->service层->dao层->mysql数据库
                    真正流程图：jsp->controller层->service层->dao层->mysql数据库
            测试类在网站开发中并没有起到占什么位置，只是如果开发用来检验错误的，如果错误解决了，测试类就算删除也没有问题，当然还是建议如果删除还是
            要留下一个供参考，方便后面出现错误方便编写
            
            
            以上是对ssm框架的解释
            
            额外提醒：
            idea安装mybatis的插件，我所使用的idea2018.3.3的mybatis的插件貌似是收费的，如果是之前的版本还好，如果是我的这个版本的idea或者之后的最新
            版本给你一个地址https://github.com/mustfun/mybatis-plus  亲测好用，当然还是比官方付费的差点
            
            spring assistant这个免费使用，idea直接下载就行，spring其他的插件我没用过，但是这个名字在spring官网提过，所以应该比别的好用，个人理解
            
            我的另一个ssm-blog就是通过ssm修改之后上传的，这是我真正要做的项目，如果只是需要框架，直接下载ssm这个就行，提醒一下ssm只是后端框架，
            如果想要搭建一个网站的话又不想自己写前端的话，这里建议使用layui这个框架，这个框架是中国人发明的，也有人说bootstrap比较好，个人也并没有
            要吐槽的，只是说如果使用这个，你在看官方文档的也是中文，针对英语比较薄弱的童鞋，好了就讲到这里
            
            后面有什么重要的想到会补充
                      




















