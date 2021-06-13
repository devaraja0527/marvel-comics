#Marvel Comics

This project is a simple Microservice code for retrieving Marvel characters ids, character details by character id and translated character description to specified language by character id. 

This project uses Spring Boot, Spring boot log4j2  and ibm watson dependencies.


### REST API
**Get All Character Ids** 

This API retrieve's all the character ids from JSON file stored in **'src/main/resources/application.yml'** file.

```bash
  Method : GET
  End Point: http://localhost:8080/characters 
  Content-type : application/json
  SAMPLE JSON RESPONSE:
  [1011334,1017100,1009144]   
```
**Get Character Details By Character Id** 

This API retrieve's character Id,name , description and thumbnail as below from real time Marvel API.

```bash
  Method : GET
  End Point: http://localhost:8080/characters/{characterId}
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
  End Point: http://localhost:8080/characters/{characterId}?language={languageCode}
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


