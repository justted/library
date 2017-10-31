function deletebook(bnum){
	$.ajax({
		url:"http://localhost:8080/library/book/delbook.do",
		type:"post",
		data:{"bnum":bnum},
		dataType:"json",
		success:function(result){							
			if(result.status===0){
				alert(result.msg);
				window.location.href="listBook.html";
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("删除异常");
		}
		
	});
	
}