<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="panel panel-default">
    <div class="panel-heading">
				<div class="clearfix">
					<h1 class="panel-title aw-titulo-panel">Pesquisar Processo</h1>
					<a class="btn btn-link aw-link-panel" href="/irbusca">Novo processo</a>
				</div>

    </div>
    <div class="panel-body">
<form action='/pesquisar' method='get'>

	<table class='table table-hover table-responsive table-bordered'>

		<tr>
			<td><b>N pub</b></td>
			<td><input type='text' name='pub' class='form-control' required /></td>
			<td>
				<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i>  Buscar</button>
			</td>
		</tr>

	</table>
</form>
<form:form id="frmForm" action='/add' method='post'  modelAttribute="processo">
	<table class='table table-hover table-responsive table-bordered'>
		<tr>
			<td><b>N pub</b></td>
			<td><form:input type='text' cssClass="form-control" cssStyle="size: 20" path="pub" readonly="true"/></td>
		</tr>
		<tr>
			<td><b>N do pedido internacional</b></td>
			<td><form:input type='text' cssClass="form-control" cssStyle="size: 20" path="pedidoInternacional" readonly="true"/></td>
		</tr>
		<tr>
			<td><b>Data de publicação:</b></td>
			<td><form:input type='text' cssClass="form-control" cssStyle="size: 20" path="dataPublicacao" readonly="true"/></td>

		</tr>
		<tr>
			<td><b>Requerente:</b></td>
			<td><form:input type='text' cssClass="form-control" cssStyle="size: 20" path="requerente" readonly="true"/></td>
		</tr>
		<tr>
			<td><b>Título:</b></td>
			<td><form:input type='text' cssClass="form-control" cssStyle="size: 20" path="titulo" readonly="true"/></td>
		</tr>

	</table>
</form:form>
    </div>
</div>



<%-- <jsp:include page="footer.jsp"></jsp:include> --%>