 **Alinainai博客系统** 
1. 完全参照SPPanBlog4SpringBoot(https://gitee.com/whoismy8023/sppanblog4springboot)项目二次开发。
2. 后台使用springboot、spring data jpa实现。全文检索使用Lucene。
3. 模版引擎使用超级经典的freemarker。
4. 管理后台UI使用H+后台模版框架。
5. 页面前台使用超级小清新的layui。
6. 数据库使用MySQL。我开发的时候使用的MySQL，理论上可以支持各种形式的数据库，但是需要更换驱动类。  
设置spring.jpa.properties.hibernate.hbm2ddl.auto=create以后，可以自动创建数据表。
7. 对数据的操作大部分使用了SpringBoot天然支持的JPA，同时也集成了mybatis使用CRUD注解辅助数据操作。

系统截图：  
![输入图片说明](http://git.oschina.net/uploads/images/2017/0411/205539_eee2b847_559378.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2017/0411/205603_bfca9484_559378.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2017/0411/205601_8719a026_559378.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2017/0411/205645_8a1b3a5b_559378.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2017/0411/205708_8f5db6e3_559378.png "在这里输入图片标题")
