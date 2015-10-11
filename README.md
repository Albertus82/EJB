# EJB
Piccoli progetti esemplificativi di alcune delle funzionalità degli EJB, testati con **WildFly 8.2.1**. &Egrave; richiesta la dichiarazione di un datasource **MyDataSource** nell'application server.

Per dichiarare un datasource Oracle, aggiungere al file **`standalone.xml`** di **WildFly** i seguenti elementi **`datasource`** e **`driver`** nei rispettivi contenitori `datasources` e `drivers` preesistenti, modificando ovviamente i parametri a seconda della propria configurazione:

```xml
<datasources>
	<datasource jndi-name="java:/MyDataSource" pool-name="OracleDS"
		enabled="true">
		<connection-url>jdbc:oracle:thin:@localhost:1521:XE</connection-url>
		<driver>oracle</driver>
		<pool>
			<min-pool-size>1</min-pool-size>
			<max-pool-size>3</max-pool-size>
			<prefill>true</prefill>
		</pool>
		<security>
			<user-name>db_username</user-name>
			<password>db_username</password>
		</security>
	</datasource>
	<drivers>
		<driver name="oracle" module="com.oracle">
			<driver-class>oracle.jdbc.driver.OracleDriver</driver-class>
		</driver>
	</drivers>
</datasources>
```

Creare quindi un'alberatura `modules\system\layers\base\oracle\main` nella directory dell'application server e copiarvi la libreria JDBC di Oracle (tipicamente `ojdbc14.jar` o `ojbc6.jar`). Aggiungere infine un file **`module.xml`** del tipo seguente:

```xml
<module xmlns="urn:jboss:module:1.1" name="oracle">
	<resources>
		<resource-root path="ojdbc6.jar" />
	</resources>
	<dependencies>
		<module name="javax.api" />
		<module name="javax.transaction.api" />
	</dependencies>
</module>
```
