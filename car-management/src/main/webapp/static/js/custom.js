$(function() {
	var curl_url = window.location;
    var element = $('ul.children a').filter(function() {
        return this.href == curl_url || curl_url.href.indexOf(this.href) == 0;
    }).addClass('children-active').parent().parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
	}
});


!function ($) {
			$(document).on("click","ul.nav li.parent>a", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})