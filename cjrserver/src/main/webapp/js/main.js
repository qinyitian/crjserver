;(function () {
	

	'use strict';

	// Placeholder 
	var placeholderFunction = function() {
		$('input, textarea').placeholder({ customClass: 'my-placeholder' });
	}
	
	// Placeholder 
	var contentWayPoint = function() {
		var i = 0;
		$('.animate-box').waypoint( function( direction ) {

			if( direction === 'down' && !$(this.element).hasClass('animated-fast') ) {
				
				i++;

				$(this.element).addClass('item-animate');
				setTimeout(function(){

					$('body .animate-box.item-animate').each(function(k){
						var el = $(this);
						setTimeout( function () {
							var effect = el.data('animate-effect');
							if ( effect === 'fadeIn') {
								el.addClass('fadeIn animated-fast');
							} else if ( effect === 'fadeInLeft') {
								el.addClass('fadeInLeft animated-fast');
							} else if ( effect === 'fadeInRight') {
								el.addClass('fadeInRight animated-fast');
							} else {
								el.addClass('fadeInUp animated-fast');
							}

							el.removeClass('item-animate');
						},  k * 200, 'easeInOutExpo' );
					});
					
				}, 100);
				
			}

		} , { offset: '85%' } );
	};
	// On load
	$(function(){
		placeholderFunction();
		contentWayPoint();

	});

}());
$(function () {

    'use strict';


    var $citypicker1 = $('#city-picker1');

    $citypicker1.citypicker();

    var $citypicker2 = $('#city-picker2');

    $citypicker2.citypicker({
        province: '江苏省',
        city: '常州市',
        district: '溧阳市'
    });

    var $citypicker3 = $('#city-picker3');

    $('#reset').click(function () {
        $citypicker3.citypicker('reset');
    });

    $('#destroy').click(function () {
        $citypicker3.citypicker('destroy');
    });
    //
    //$('#distpicker1').distpicker();
    //
    //$('#distpicker2').distpicker({
    //  province: '---- 所在省 ----',
    //  city: '---- 所在市 ----',
    //  district: '---- 所在区 ----'
    //});
    //
    //$('#distpicker3').distpicker({
    //  province: '浙江省',
    //  city: '杭州市',
    //  district: '西湖区'
    //});
    //
    //$('#distpicker4').distpicker({
    //  placeholder: false
    //});
    //
    //$('#distpicker5').distpicker({
    //  autoSelect: false
    //});

});
