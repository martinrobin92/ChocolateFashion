$(function() {

	switch (menu) {

	case 'About Us':
		$("#about").addClass('active');
		break;

	case 'Contact Us':
		$("#contact").addClass('active');
		break;

	case 'All Products':
		$("#listproducts").addClass('active');
		break;

	default:
		$("#home").addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// Jquery
	var $table = $("#listofprod");

	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
	
		$table.DataTable( {
			
			lengthMenu : [[3,5,10,-1],["3 records","5 records","10 records","All"]],
			
			pageLength : 5,
		
			
			ajax :{
				
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{
					data :'code',
					mRender : function(data,type,row){
						return '<img src ="'+window.contextRoot+'/assets/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				
				{
					data : 'name'
				},
				{
					data : 'quantity',
					mRender:function(data,type,row){
						if(data < 1){
							return '<span style="color:red">Out Of Stock</span>';
						}
						return data;
					}
				},
				{
					data : 'unitPrice',
					mRender : function(data , type , row){
						return "&#8377; "  + data
					}
				},
				{
					data : 'id',
					bSortable : false ,
					mRender : function(data, type , row){
						var str = '';
						
						str += '<a href ="'+window.contextRoot+'/show/'+data+'/products" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						if(row.quantity < 1){
							str += '<a href ="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';	
						}
						else{
							str += '<a href ="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							
						}
						
						
						return str;
					}
				}
			]
			
			
			
		});
		
	}
		
});		
		
	



















/*$.ajax({
			url : jsonUrl,
			type : 'GET',
			
			timeout : 50000,
			success : function(response) {
			$.each(response , function(i,data){
				$("#listofprod").append("<tr>" +
			
			"<td>"+response[i].name+"</td>" +
			"<td>"+response[i].quantity+"</td>" +
			"<td>"+response[i].unitPrice+"</td>"+
			
					"</tr>");
			})
				
			},
			error : function(xhr, status, error) {
				 alert(xhr.responseText);
			}
		});
	}*/
		
	

