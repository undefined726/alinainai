<#macro html title>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="${siteName!}">
	<meta name="keywords" content="${siteName!}">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>${title!}</title>
	<meta name="renderer" content="webkit">
	<link rel="shortcut icon" type="image/png" href="${ctx!}/front/i/favicon.png">
	<meta http-equiv="Cache-Control" content="no-siteapp"/>
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-title" content="${siteName!}"/>
	<meta name="msapplication-TileColor" content="#0e90d2">

	<link rel="stylesheet" href="${ctx!}/front/css/amazeui.min.css">
	<link rel="stylesheet" href="${ctx!}/front/layui/css/layui.css"/>
	<link rel="stylesheet" href="${ctx!}/front/css/app.css"/>
	${css!}
</head>

<body id="blog">
	<header class="am-topbar am-topbar-fixed-top qing-header">
		<div class="am-g am-g-fixed">
			<h1 class="am-topbar-brand qing-logo">
				${siteName!}
			</h1>
			<!-- nav start -->
			<nav class="am-g am-g-fixed qing-fixed qing-nav">
			<button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-show-sm-only am-radius qing-btn-mobile" data-am-collapse="{target: '#blog-collapse'}" ><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
                <div class="am-collapse am-topbar-collapse" id="blog-collapse">
                    <ul class="am-nav am-nav-pills am-topbar-nav nav-menu-box">
                        <li><a href="${ctx!}/">首页</a></li>
						<@categoryList>
							<#list list as x>
                                <li><a href="${ctx!}/b/${(x.id)!}">${(x.name)!}</a></li>
							</#list>
						</@categoryList>
                        <li><a href="${ctx!}/about">关于</a></li>
                    </ul>
                    <form class="am-topbar-form am-topbar-right am-form-inline layui-form am-hide-sm-only" role="search" action="${ctx!}/s/">
                        <div class="am-form-group am-form-icon">
                            <input id="keyword" name="keyword" type="text" value="${keyWord!}"
                                   class="am-form-field am-input-sm am-radius" placeholder="请输入要搜索的关键词">
                            <i class="am-icon-search"></i>
                            <button type="submit" class="layui-btn layui-btn-small am-hide-sm-only qing-btn-search">搜索</button>
                        </div>
                    </form>
                </div>
			</nav>
		</div>
		<!-- nav end -->
	</header>

	<!--mobile search input start -->
	<div class="am-show-sm-only am-u-sm-12 qing-sm-search">
        <form class="m-topbar-form am-topbar-right am-form-inline layui-form" role="search" action="${ctx!}/s/">
            <div class="am-form-group am-form-icon">
                <i class="am-icon-search"></i>
                <input id="keyword" name="keyword" value="${keyWord!}" type="text"
                       class="am-form-field am-form-field am-radius" placeholder="请输入要搜索的关键词">
            </div>
        </form>
	</div>
	<!--mobile search input end -->

	<!-- content srart -->
	<div class="am-g am-g-fixed qing-fixed qing-container">
		<!-- blog start-->
	    <div class="am-u-md-8 am-u-sm-12">
	    	<#nested>
	    </div>
	    <!-- blog end -->
		<!-- sideBar start -->
	    <div class="am-u-md-4 am-u-sm-12">
	    	<#include "${ctx!}/front/layout/_sidebar.ftl" />
	    </div>
	    <!-- sideBar end-->
	</div>
	<!-- content end -->

  	<footer class="qing-footer">
		<div class="qing-text-center">
			<p class="am-text-sm">${siteDescription!}</p>
		</div>
		<div class="qing-text-center">Copyright © 2017 ${siteName!}  |  All Rights Reserved.  |  power by xiaobai</div>
  	</footer>

	<#-- External JS BOF -->
	<script src="${ctx!}/front/js/jquery.min.js"></script>
	<script src="${ctx!}/front/js/amazeui.min.js"></script>
	<script src="${ctx!}/front/layui/layui.js"></script>
	<#-- External JS EOF -->

	<script type="text/javascript">
		$(document).ready(function() {
			setCurrentNavMenu();
		});
		/**
		 * 设置当前导航菜单
		 */
		function setCurrentNavMenu() {
			var url = location.pathname, navMenus = $(".nav-menu-box li");
			$.each(navMenus, function(p1, p2) {
				if (!url.indexOf('/b/' + p1)){
					navMenus.eq(p1).addClass("am-active");
				}
			});

			//关于菜单高亮
			if(!url.indexOf('/about')){
				navMenus.last().addClass("am-active");
			}
		}
	</script>
	
	${js!}
</body>
</html>
</#macro>