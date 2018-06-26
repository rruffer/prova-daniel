<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="header.jsp"></jsp:include>

<div class="panel panel-default">
	<div class="panel-heading">
		<div class="clearfix">
			<h1 class="panel-title aw-titulo-panel">Novo Título</h1>
			<a class="btn btn-link aw-link-panel" href="/irpesquisar">Pesquisar
				processo</a>
		</div>

	</div>
	<div class="panel-body">
		<form action='/buscar' method='get'>
			<table class='table table-hover table-responsive table-bordered'>

				<tr>
					<td><b>N pub</b></td>
					<td><input id="id-pub" type='text' name='pub'
						class='form-control' required /></td>
					<td>
						<button type="submit" class="btn btn-primary">
							<i class="fa fa-search"></i> Buscar
						</button>
					</td>
				</tr>

			</table>
		</form>
		<form:form id="frmForm" action='/add' method='post'
			modelAttribute="processo">
			<table class='table table-hover table-responsive table-bordered'>
				<tr>
					<td><b>N pub</b></td>
					<td><form:input id="pub" type='text' cssClass="form-control"
							cssStyle="size: 20" path="pub" readonly="true" /></td>
				</tr>
				<tr>
					<td><b>N do pedido internacional</b></td>
					<td><form:input id="pedidoInternacional" type='text'
							cssClass="form-control" cssStyle="size: 20"
							path="pedidoInternacional" readonly="true" /></td>
				</tr>
				<tr>
					<td><b>Data de publicação:</b></td>
					<td><form:input id="dataPublicacao" type='text'
							cssClass="form-control" cssStyle="size: 20" path="dataPublicacao"
							readonly="true" /></td>

				</tr>
				<tr>
					<td><b>Requerente:</b></td>
					<td><form:input id="requerente" type='text'
							cssClass="form-control" cssStyle="size: 20" path="requerente"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><b>Título:</b></td>
					<td><form:input id="titulo" type='text'
							cssClass="form-control" cssStyle="size: 20" path="titulo"
							readonly="true" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="btn-cadastrar" type="submit"
							class="btn btn-primary btn-lg btn-block">
							<i class="fa fa-floppy-o"></i> Salvar
						</button>
					</td>
				</tr>


			</table>
		</form:form>
	</div>
</div>



<%-- <jsp:include page="footer.jsp"></jsp:include> --%>