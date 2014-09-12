/**
 * 
 */

var menu = {'mnu-1-dashboard' : 'pages/dashboard.html',
			'mnu-2-cashinflow' : 'cash-inflow/crud.do',
			'mnu-2-cashoutflow' : 'pages/cash-out.html'};

function loadToTarget(url, targetDiv) {
	$("#" + targetDiv).load(url);
}

function postJsonAndLoadToTarget(url, targetDiv, json){
	$.ajax({
	       url : url,
	       type : 'POST',
	       contentType : 'application/json',
	       data : JSON.stringify(json),
	       success : function(data){
	    	   $('#' + targetDiv).html(data);
	       }
		});
}

function activeMenu(aObj) {
	clearActiveMenu();

	aObj.addClass('active');
	
	loadToTarget(menu[aObj.attr('id')], 'page-content');
}

function clearActiveMenu() {
	for ( var key in menu) {
		if (menu.hasOwnProperty(key)) {
			$('#' + key).removeClass('active');
		}
	}
}