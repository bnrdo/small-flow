/**
 * 
 */

var menu = {'mnu-1-dashboard' : 'dashboard.html',
			'mnu-2-cashinflow' : 'cash-in.html',
			'mnu-2-cashoutflow' : 'cash-out.html'};

function loadToTarget(url, targetDiv) {
	$("#" + targetDiv).load(url);
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