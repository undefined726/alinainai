<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 友情链接信息</title>
    <meta name="keywords" content="">
    <meta name="descriptionription" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${ctx!}/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/admin/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>友情链接信息</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/youlian/save">
                        	<input type="hidden" id="id" name="id" value="${(youlian.id)!}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">名称：</label>
                                <div class="col-sm-8">
                                    <input id="title" name="title" class="form-control" type="text" value="${(youlian.title)!}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">URL地址：</label>
                                <div class="col-sm-8">
                                    <input id="url" name="url" class="form-control" type="text" value="${(youlian.url)!}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-8">
                                	<select name="status" class="form-control">
                                		<option value="0" <#if youlian.status == 0>selected="selected" </#if>>显示</option>
                                		<option value="1" <#if youlian.status == 1>selected="selected" </#if>>隐藏</option>
                                	</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">描述：</label>
                                <div class="col-sm-8">
                                    <input id="description" name="description" class="form-control" value="${(youlian.description)!}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="${ctx!}/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx!}/admin/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="${ctx!}/admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="${ctx!}/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${ctx!}/admin/js/plugins/validate/messages_zh.min.js"></script>
    <script src="${ctx!}/admin/js/plugins/layer/layer.min.js"></script>
    <script src="${ctx!}/admin/js/plugins/layer/laydate/laydate.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
	    $("#frm").validate({
    	    rules: {
    	    	title: {
    	        required: true,
    	        minlength: 2,
    	        maxlength: 8
    	      },url: {
    	        required: true,
    	        url:true
    	      },
    	      	description: {
    	        maxlength: 40
    	      }
    	    },
    	    messages: {},
    	    submitHandler:function(form){
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/youlian/save",
   	    		   data: $(form).serialize(),
   	    		   success: function(ret){
	   	    			if(ret.isOk){
		   	    			layer.msg("操作成功", {time: 2000},function(){
		   						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		   						parent.layer.close(index); 
		   					});
   	    		   	    }else{
   	    		   	  		layer.msg(ret.msg, {time: 2000});
   	    		   	    }
   	    		   }
   	    		});
            } 
    	});
    });
    </script>

</body>

</html>
