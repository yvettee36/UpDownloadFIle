1.准备环境
	1.1 导开发包
		mysql驱动
		c3po连接池
		dbutils
		fileupload组件
		io包
		beanUtils开发包
		log4j开发包
		jstl开发
		
	1.2 创建组织程序的包
	
	
	1.3 准备库和表
		create database testbatch;
		use testbatch;
		create table upfile
		(
			id varchar(40) primary key,
			uuidname varchar(100) not null unique,
			filename varchar(100) not null,
			savepath varchar(255) not null,
			uptime datetime not null,
			description varchar(255),
			username varchar(40) not null
		);
	
2.做实体

3.做dao

4.做service

5.做web层

简书地址：http://www.jianshu.com/p/f9e18ff6ceb3