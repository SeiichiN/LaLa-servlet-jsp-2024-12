/**
 * 
 */
 'use strict';
 
 const menu_btn = document.getElementById('menu-btn');
 const menu_area = document.getElementById('menu-area');
  
 menu_btn.onclick = function() {
	if (window.innerWidth < 768) {
		if (menu_area.style.display === 'none') {
			menu_area.style.display = "block";
		} else {
			menu_area.style.display = "none";
		}		
	}
}