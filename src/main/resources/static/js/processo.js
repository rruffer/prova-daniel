$(function() {
	$('.btn-ajax').on('click', function(event) {
		event.preventDefault();
		
		var botaoReceber = $(event.currentTarget);
		var valor = $("#id-pub").val();
		var urlreq  = botaoReceber.attr('href') + valor;
		
		var response = $.ajax({
			url: urlreq,
			type: 'GET'
		});
		
		response.done(function(e) {
			$("#pub").val(e.pub);
			$("#pedidoInternacional").val(e.pedidoInternacional);
			$("#dataPublicacao").val(e.dataPublicacao);
			$("#requerente").val(e.requerente);
			$("#titulo").val(e.titulo);
		});
		
		response.fail(function(e) {
			//console.log(e);
			alert('Erro: ' + e);
		});
		
	});
});
