function findByBnum(bnum){
	$.ajax({
		url:"http://localhost:8080/library/book/findByBnum.do",
		type:"post",
		data:{"bnum":bnum},
		dataType:"json",
		success:function(result){
			//解析返回的JSON结果
			if(result.status==0){//成功
				var book = result.data;
				alert(result.msg);
				//将查询到的图书信息添加到input文本框中
				$("#id").html(book.id);
				$("#bnum").val(book.bnum);
				$("#bname").val(book.bname);
				$("#bwriter").val(book.bwriter);
				$("#bpublish").val(book.bpublish);
				$("#status").val(book.status==0?"未借出":"已借出");
				$("#beizhu").val(book.beizhu);
			}else {
				alert(result.msg);
			}
		},
		error:function(){
			alert("查询异常");
		}
	});
}