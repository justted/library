function updatebook(bnum){
	//alert(bnum);
	
	//alert("-----");
				//添加图书-提交按钮单击处理
				$("#updatebook").click(function(){									
					//获取请求要提交的数据
					 var id = $("#id").html().trim();
					 var bnum = $("#bnum").val().trim();
					 var bname = $("#bname").val().trim();
					 var bwriter = $("#bwriter").val().trim();
					 var bpublish = $("#bpublish").val().trim();
					 var status = $("#status").val().trim();
					 var beizhu = $("#beizhu").val().trim();
					 alert(id+bnum+bname+bwriter+bpublish+status+beizhu);
					//检测数据格式合法性
					var flag = true;//通过检测
					if(bnum=="" || bname=="" || bwriter=="" || bpublish=="" || status==""){
						alert("添加信息不能为空");
						flag = false;//未通过检测
					}
					//TODO 索书号、书名是否已存在，在Impl中实现
					
					//通过检测，发送ajax请求
					if(flag){					
						$.ajax({
							url:"http://localhost:8080/library/book/updatebook.do",
							type:"post",
							data:{"id":id,
								  "bnum":bnum,
								  "bname":bname,
								  "bwriter":bwriter,
								  "bpublish":bpublish,
								  "status":status,
								  "beizhu":beizhu},
							dataType:"json",
							success:function(result){
								//解析返回的JSON结果
								if(result.status==0){//成功
									alert(result.msg);
									window.location.href="listBook.html";						
								}else {
									alert(result.msg);
								}
							},
							error:function(){
								alert("修改异常");
							}						
						});
					}
							
				});
}