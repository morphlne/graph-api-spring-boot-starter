### graph-api-spring-boot-starter

Spring Boot starter for [graph-api-authentication](https://github.com/morphlne/graph-api-authentication) library

Demo can be found [here](https://github.com/morphlne/graph-api-demo/tree/master/demo-with-starter)

### Usage

1. Add any Spring Boot starter dependency (provides `spring-boot` & `spring-boot-autoconfigure`)
2. Add [Microsoft Graph Java SDK](https://mvnrepository.com/artifact/com.microsoft.graph/microsoft-graph) dependency
3. Specify following properties under `graph-api`:
- **clientId** - application (client) ID
- **clientSecret** - application secret
- **tenant** - directory (tenant) ID
- **scopes** - list of scopes. Optional. `https://graph.microsoft.com/.default` used by default
- **nationalCloud** - national cloud using for authentication. Optional. `https://login.microsoftonline.com` used by default

Additionally for delegate permissions should be specified:
- **user** - userPrincipalName
- **password** - user password
- **onlyDelegate** - `true`, if application authentication bean is excess. Optional

4. Autowire `IGraphServiceClient` bean, distinguished by name:
- applicationGraphClient - provides application permissions
- delegateGraphClient - provides delegate permissions
