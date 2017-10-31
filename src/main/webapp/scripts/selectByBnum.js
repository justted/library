function selectByBnum(){
	$("#findbook_result .row1,.row2").empty();
	var bnum = $("#book_msg").val().trim();
	var flag = true;
	if(bnum==""){
		flag = false;
		alert("索书号不能为空");
	}
		
	if(flag){
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
					var bookId = book.id;
					var bookNum = book.bnum;
					var bookName = book.bname;
					var bookWriter = book.bwriter;
					var bookPublish = book.bpublish;
					var bookStatus = book.status==0?"未借出":"已借出";
					var bookBeizhu = book.beizhu;
					//alert(bookStatus);
					var s_li = '<tr class="row1">';
					s_li += '<td>'+bookId+'</td>';
					s_li += '<td>'+bookNum+'</td>';
					s_li += '<td>'+bookName+'</td>';
					s_li += '<td>'+bookWriter+'</td>';
					s_li += '<td>'+bookPublish+'</td>';
					s_li += '<td>'+bookStatus+'</td>';							
					s_li += '<td>'+bookBeizhu+'</td>';							
					s_li += '</tr>';
									
					var $li = $(s_li);
					$li.data("bookId",bookId);
					$("#findbook_result").append($li);				
					//$(".table").attr("display","block");
					//$("#findbook_result").removeClass();					
				}else {
					alert(result.msg);
				}
			},
			error:function(){
				alert("查询异常");
			}
		});
						
	}
							
}
