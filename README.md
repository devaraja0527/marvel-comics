v1/#### Marvel Comics

This project is a simple Microservice code for retrieving Marvel characters ids, character details by character id and translated character description to specified language by character id. 

This project uses Spring Boot, Spring boot log4j2  and ibm watson dependencies.


### REST API
**Get All Character Ids** 

This API retrieve's all the character ids from JSON file stored in **'src/main/resources/application.yml'** file.

```bash
  Method : GET
  End Point: http://localhost:8080/v1/characters 
  Content-type : application/json
  SAMPLE JSON RESPONSE:
  [1011334,1017100,1009144]   
```
**Get Character Details By Character Id** 

This API retrieve's character Id,name , description and thumbnail as below from real time Marvel API.

```bash
  Method : GET
  End Point: http://localhost:8080/v1/characters/{characterId}
  Content-type : application/json
  SAMPLE JSON RESPONSE:
   {
	"id": 1011334,
	"name": "3-D Man",
	"description": "",
	"thumbnail": {
		"path": "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
		"extension": "jpg"
	}
   }
```
**Get Translated Character Description By Character Id** 

This API retrieve's character Id,name , thumbnail and description , the description is translated as below from real time Marvel API.

Request Param (language) can be given ISO-639-1 code or full language name 

```bash
  Method : GET
  End Point: http://localhost:8080/v1/scharacters/{characterId}?language={languageCode}
  Content-type : application/json
  SAMPLE JSON RESPONSE:
   {
	"id": 1017100,
	"name": "A-Bomb (HAS)",
	"description": "[{\n  \"translation\": \"రిక్ జోన్స్ రోజు నుండి హల్క్ యొక్క ఉత్తమ బూడిద ఉంది, కానీ ఇప్పుడు అతను ఒక స్నేహితుడు కంటే ఎక్కువ ఉంది ... అతను ఒక साथी ఉంది! ఒక గామా శక్తి విస్ఫోటనం ద్వారా ట్రాన్స్పోర్ట్, A-బాంబ్ యొక్క గాఢత, ఆర్మేనిట్ చర్మం కేవలం బలమైన మరియు శక్తివంతంగా ఉంది. మరియు అతను చర్య లోకి curls, అతను నాశనం యొక్క ఒక పెద్ద బౌలింగ్ బంతి వంటి దానిని ఉపయోగిస్తుంది! \"\n}]",
	"thumbnail": {
		"path": "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
		"extension": "jpg"
	}
}
```

**Sample Error Response**

```bash

{"cause":null,"stackTrace":[{"methodName":"handleInvalidRequestDataException","fileName":"CustomizedResponseEntityExceptionHandler.java","lineNumber":72,"className":"com.marvel.comics.exception.CustomizedResponseEntityExceptionHandler","nativeMethod":false},{"methodName":"invoke0","fileName":"NativeMethodAccessorImpl.java","lineNumber":-2,"className":"sun.reflect.NativeMethodAccessorImpl","nativeMethod":true},{"methodName":"invoke","fileName":"NativeMethodAccessorImpl.java","lineNumber":62,"className":"sun.reflect.NativeMethodAccessorImpl","nativeMethod":false},{"methodName":"invoke","fileName":"DelegatingMethodAccessorImpl.java","lineNumber":43,"className":"sun.reflect.DelegatingMethodAccessorImpl","nativeMethod":false},{"methodName":"invoke","fileName":"Method.java","lineNumber":498,"className":"java.lang.reflect.Method","nativeMethod":false},{"methodName":"doInvoke","fileName":"InvocableHandlerMethod.java","lineNumber":197,"className":"org.springframework.web.method.support.InvocableHandlerMethod","nativeMethod":false},{"methodName":"invokeForRequest","fileName":"InvocableHandlerMethod.java","lineNumber":141,"className":"org.springframework.web.method.support.InvocableHandlerMethod","nativeMethod":false},{"methodName":"invokeAndHandle","fileName":"ServletInvocableHandlerMethod.java","lineNumber":106,"className":"org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod","nativeMethod":false},{"methodName":"doResolveHandlerMethodException","fileName":"ExceptionHandlerExceptionResolver.java","lineNumber":428,"className":"org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver","nativeMethod":false},{"methodName":"doResolveException","fileName":"AbstractHandlerMethodExceptionResolver.java","lineNumber":75,"className":"org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver","nativeMethod":false},{"methodName":"resolveException","fileName":"AbstractHandlerExceptionResolver.java","lineNumber":141,"className":"org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver","nativeMethod":false},{"methodName":"resolveException","fileName":"HandlerExceptionResolverComposite.java","lineNumber":80,"className":"org.springframework.web.servlet.handler.HandlerExceptionResolverComposite","nativeMethod":false},{"methodName":"processHandlerException","fileName":"DispatcherServlet.java","lineNumber":1323,"className":"org.springframework.web.servlet.DispatcherServlet","nativeMethod":false},{"methodName":"processDispatchResult","fileName":"DispatcherServlet.java","lineNumber":1134,"className":"org.springframework.web.servlet.DispatcherServlet","nativeMethod":false},{"methodName":"doDispatch","fileName":"DispatcherServlet.java","lineNumber":1080,"className":"org.springframework.web.servlet.DispatcherServlet","nativeMethod":false},{"methodName":"doService","fileName":"DispatcherServlet.java","lineNumber":963,"className":"org.springframework.web.servlet.DispatcherServlet","nativeMethod":false},{"methodName":"processRequest","fileName":"FrameworkServlet.java","lineNumber":1006,"className":"org.springframework.web.servlet.FrameworkServlet","nativeMethod":false},{"methodName":"doGet","fileName":"FrameworkServlet.java","lineNumber":898,"className":"org.springframework.web.servlet.FrameworkServlet","nativeMethod":false},{"methodName":"service","fileName":"HttpServlet.java","lineNumber":626,"className":"javax.servlet.http.HttpServlet","nativeMethod":false},{"methodName":"service","fileName":"FrameworkServlet.java","lineNumber":883,"className":"org.springframework.web.servlet.FrameworkServlet","nativeMethod":false},{"methodName":"service","fileName":"HttpServlet.java","lineNumber":733,"className":"javax.servlet.http.HttpServlet","nativeMethod":false},{"methodName":"internalDoFilter","fileName":"ApplicationFilterChain.java","lineNumber":227,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilter","fileName":"ApplicationFilterChain.java","lineNumber":162,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilter","fileName":"WsFilter.java","lineNumber":53,"className":"org.apache.tomcat.websocket.server.WsFilter","nativeMethod":false},{"methodName":"internalDoFilter","fileName":"ApplicationFilterChain.java","lineNumber":189,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilter","fileName":"ApplicationFilterChain.java","lineNumber":162,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilterInternal","fileName":"RequestContextFilter.java","lineNumber":100,"className":"org.springframework.web.filter.RequestContextFilter","nativeMethod":false},{"methodName":"doFilter","fileName":"OncePerRequestFilter.java","lineNumber":119,"className":"org.springframework.web.filter.OncePerRequestFilter","nativeMethod":false},{"methodName":"internalDoFilter","fileName":"ApplicationFilterChain.java","lineNumber":189,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilter","fileName":"ApplicationFilterChain.java","lineNumber":162,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilterInternal","fileName":"FormContentFilter.java","lineNumber":93,"className":"org.springframework.web.filter.FormContentFilter","nativeMethod":false},{"methodName":"doFilter","fileName":"OncePerRequestFilter.java","lineNumber":119,"className":"org.springframework.web.filter.OncePerRequestFilter","nativeMethod":false},{"methodName":"internalDoFilter","fileName":"ApplicationFilterChain.java","lineNumber":189,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilter","fileName":"ApplicationFilterChain.java","lineNumber":162,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilterInternal","fileName":"CharacterEncodingFilter.java","lineNumber":201,"className":"org.springframework.web.filter.CharacterEncodingFilter","nativeMethod":false},{"methodName":"doFilter","fileName":"OncePerRequestFilter.java","lineNumber":119,"className":"org.springframework.web.filter.OncePerRequestFilter","nativeMethod":false},{"methodName":"internalDoFilter","fileName":"ApplicationFilterChain.java","lineNumber":189,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"doFilter","fileName":"ApplicationFilterChain.java","lineNumber":162,"className":"org.apache.catalina.core.ApplicationFilterChain","nativeMethod":false},{"methodName":"invoke","fileName":"StandardWrapperValve.java","lineNumber":202,"className":"org.apache.catalina.core.StandardWrapperValve","nativeMethod":false},{"methodName":"invoke","fileName":"StandardContextValve.java","lineNumber":97,"className":"org.apache.catalina.core.StandardContextValve","nativeMethod":false},{"methodName":"invoke","fileName":"AuthenticatorBase.java","lineNumber":542,"className":"org.apache.catalina.authenticator.AuthenticatorBase","nativeMethod":false},{"methodName":"invoke","fileName":"StandardHostValve.java","lineNumber":143,"className":"org.apache.catalina.core.StandardHostValve","nativeMethod":false},{"methodName":"invoke","fileName":"ErrorReportValve.java","lineNumber":92,"className":"org.apache.catalina.valves.ErrorReportValve","nativeMethod":false},{"methodName":"invoke","fileName":"StandardEngineValve.java","lineNumber":78,"className":"org.apache.catalina.core.StandardEngineValve","nativeMethod":false},{"methodName":"service","fileName":"CoyoteAdapter.java","lineNumber":357,"className":"org.apache.catalina.connector.CoyoteAdapter","nativeMethod":false},{"methodName":"service","fileName":"Http11Processor.java","lineNumber":374,"className":"org.apache.coyote.http11.Http11Processor","nativeMethod":false},{"methodName":"process","fileName":"AbstractProcessorLight.java","lineNumber":65,"className":"org.apache.coyote.AbstractProcessorLight","nativeMethod":false},{"methodName":"process","fileName":"AbstractProtocol.java","lineNumber":893,"className":"org.apache.coyote.AbstractProtocol$ConnectionHandler","nativeMethod":false},{"methodName":"doRun","fileName":"NioEndpoint.java","lineNumber":1707,"className":"org.apache.tomcat.util.net.NioEndpoint$SocketProcessor","nativeMethod":false},{"methodName":"run","fileName":"SocketProcessorBase.java","lineNumber":49,"className":"org.apache.tomcat.util.net.SocketProcessorBase","nativeMethod":false},{"methodName":"runWorker","fileName":"ThreadPoolExecutor.java","lineNumber":1149,"className":"java.util.concurrent.ThreadPoolExecutor","nativeMethod":false},{"methodName":"run","fileName":"ThreadPoolExecutor.java","lineNumber":624,"className":"java.util.concurrent.ThreadPoolExecutor$Worker","nativeMethod":false},{"methodName":"run","fileName":"TaskThread.java","lineNumber":61,"className":"org.apache.tomcat.util.threads.TaskThread$WrappingRunnable","nativeMethod":false},{"methodName":"run","fileName":"Thread.java","lineNumber":748,"className":"java.lang.Thread","nativeMethod":false}],"errorData":{"statusCode":400,"code":null,"message":"Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long'; nested exception is java.lang.NumberFormatException: For input string: \"ss\""},"message":"Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long'; nested exception is java.lang.NumberFormatException: For input string: \"ss\"","localizedMessage":"Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long'; nested exception is java.lang.NumberFormatException: For input string: \"ss\"","suppressed":[]}

```

### Machine Requirements
* Java 1.8
* Maven 3.3.1 or higher


### Config Requirement

The following yml properties has to be updated in **'src/main/resources/application.yml'** file.


**Marvel API**

For the following marvel key's create developer account in [https://developer.marvel.com/](https://developer.marvel.com/) and go to my developer account and access keys.

For API Url refer to API documentation in the same menu.

``` yml
 marvel:
  url: {MARVEL_API_GATEWAY_URL}
  publicKey: {DEVELOPER_ACCOUNT_PUBLIC_KEY}
  privateKey: {DEVELOPER_ACCOUNT_PRIVE_KEY}	  
```

**IBM Watson Translation API**

**NOTE** : This library Translate up to 1,000,000 Characters per month for Free while selecting the service please make sure you're selecting the free service. 	


This library serves request based on region, refer to the document for region based url [https://cloud.ibm.com/apidocs/language-translator?code=java](https://cloud.ibm.com/apidocs/language-translator?code=java)

For getting the key we should register with [https://cloud.ibm.com/](https://cloud.ibm.com/) and After getting the free ibm cloud go to service at [https://cloud.ibm.com/catalog#services](https://cloud.ibm.com/catalog#services) and search for **Language Translator** and select the same make sure the region and plan and create.


Go To Manage and get the API and URL 

More about ibm language translator [https://www.ibm.com/docs/en/app-connect/cloud?topic=apps-watson-language-translator](https://www.ibm.com/docs/en/app-connect/cloud?topic=apps-watson-language-translator)



``` yml
ibmwatson:
    url: {REGION_BASED_TRANSLATION_URL}
    apiKey: {PRIVATE_API_KEY}  
```







### Build Local

```bash
$ mvn clean package       
```

### Run Local

```bash
$ mvn spring-boot:run
```

View the application running here: [http://localhost:8080](http://localhost:8080)


