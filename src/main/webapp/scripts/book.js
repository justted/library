function loadbooks(){
	$.ajax({
		url:"http://localhost:8080/library/book/loadbooks.do",
		type:"post",
		dataType:"json",
		success:function(result){							
			if(result.status===0){
				var books = result.data;//笔记本的json	
				//循环books，生成列表li
				for(var i=0;i<books.length;i++){
					var bookId = books[i].id;
					var bookNum = books[i].bnum;
					var bookName = books[i].bname;
					var bookWriter = books[i].bwriter;
					var bookPublish = books[i].bpublish;
					//三目运算符这里必须用==，而不能用===，不然全部都是已借出
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
					s_li += '<td>';
					s_li += '	<button class="del">删除</button>&nbsp;<button class="update">修改</button>';
					s_li += '</td>';
					s_li += '</tr>';
					
					var $li = $(s_li);
                    // 向li元素存储数据，这里只存储了bookid。
					// data()函数用于在当前jQuery对象所匹配的所有元素上存取数据
					$li.data("bookId",bookId);
					$("#book_list").append($li);
				}
				//绑定删除按钮事件
				$(".del").click(function(){
					//alert($(this).parent().parent().html());
					//本身是button，上一级parent是td，上两级parent是tr，tr的第二个children是包含bookNum的td
					var obj = $(this).parent().parent().children()[1];					
					var $child = $(obj);
					var bnum = $child.html();
					alert("索书号为："+bnum);
					//确认选择删除图书
					var msg = confirm("是否删除该图书");
				    if(msg===true){
				    	deletebook(bnum);
				    }else {
				        alert("已取消删除");
				    }
				});
				
				//绑定修改按钮事件
				$(".update").click(function(){					
					//alert($(this).parent().parent().html());
					var obj = $(this).parent().parent().children()[1];					
					var $child = $(obj);
					var bnum = $child.html();
					alert("索书号为："+bnum);
					addCookie("bnum",bnum);
					//确认选择删除图书
					var msg = confirm("是否修改该图书信息");
				    if(msg===true){
				    	window.location.href="updateBook.html";
				    }else {
				        alert("已取消修改");
				    }
				});
				
			}
		}
		
	});
	
}