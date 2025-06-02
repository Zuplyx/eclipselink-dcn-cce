# ClassCastException in OracleChangeNotificationListener with wrapped Connection

This demonstrates the ClassCastException that occurs in OracleChangeNotificationListener when using Database Change Notification with a wrapped connection. See also [eclipselink#2423](https://github.com/eclipse-ee4j/eclipselink/issues/2423).

## Setup

1. Setup Database Change Notifications for your Oracle DB according to the [documentation](https://eclipse.dev/eclipselink/documentation/4.0/solutions/solutions.html#QCN).
2. Build the project with maven.
3. Run `com.zuplyx.jpa.bugtest.TestBug` and pass url, user and password for your Oracle DB via the commandline: `java com.zuplyx.jpa.bugtest.TestBug jdbc:oracle:thin:@mydBServer:1921:MYDB user password`

This will now produce the following exception:

````
java.lang.ClassCastException: class com.zuplyx.jpa.bugtest.connection.ConnectionWrapper cannot be cast to class oracle.jdbc.OracleConnection (com.zuplyx.jpa.bugtest.connection.ConnectionWrapper and oracle.jdbc.OracleConnection are in unnamed module of loader 'app')
	at org.eclipse.persistence.platform.database.oracle.dcn.OracleChangeNotificationListener.register(OracleChangeNotificationListener.java:98)
	at org.eclipse.persistence.internal.sessions.DatabaseSessionImpl.postConnectDatasource(DatabaseSessionImpl.java:923)
	at org.eclipse.persistence.internal.sessions.DatabaseSessionImpl.loginAndDetectDatasource(DatabaseSessionImpl.java:811)
	at org.eclipse.persistence.internal.jpa.EntityManagerFactoryProvider.login(EntityManagerFactoryProvider.java:259)
	at org.eclipse.persistence.internal.jpa.EntityManagerSetupImpl.deploy(EntityManagerSetupImpl.java:770)
````
