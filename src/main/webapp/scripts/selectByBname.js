function selectByBname(){
	$("#findbook_result .row1,.row2").empty();
	var bname = $("#book_msg").val().trim();
	var flag = true;
	if(bname==""){
		flag = false;
		alert("书名不能为空");
	}
			
	if(flag){
		$.ajax({
			url:"http://localhost:8080/library/book/findByBname.do",
			type:"post",
			data:{"bname":bname},
			dataType:"json",
			success:function(result){
				//解析返回的JSON结果
				if(result.status==0){//成功
					alert(result.msg);
					var books = result.data;	
					//循环books，生成列表li
					for(var i=0;i<books.length;i++){
						var bookId = books[i].id;
						var bookNum = books[i].bnum;
						var bookName = books[i].bname;
						var bookWriter = books[i].bwriter;
						var bookPublish = books[i].bpublish;
						var bookStatus = books[i].status==0?"未借出":"已借出";
						var bookBeizhu = books[i].beizhu;
						//alert(bookStatus);
						var s_li = '<tr class="row'+(i%2+1)+'">';
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
					}
										
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