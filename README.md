# awscidr

_TBC_

## Usage

_TBC_

## Prerequisites
This was built with Java 12.0.2 and Maven 3.6.3.

It is assumed that Maven is in your execution path.

## Test and Build


```
CODEARTIFACT_AUTH_TOKEN=`aws --profile adm_rhook_cli --region eu-west-1 codeartifact get-authorization-token --domain development --domain-owner 889199313043 --query authorizationToken --output text`
mvn -s settings.xml clean package
```


Build and test using Maven:

```
$ mvn clean package
.
.
.
[INFO] Results:
[INFO]
[INFO] Tests run: 50, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ iplib ---
[INFO] Building jar: /Users/robert/Projects/Java/iplib/target/iplib-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.653 s
[INFO] Finished at: 2021-02-27T17:55:15Z
[INFO] ------------------------------------------------------------------------
```

The built JAR will be available in `target`.

JavaDoc can be generated using `mvn javadoc:javadoc`, which will create it in HTML format under `target/site/apidocs`

Alternately, use `mvn clean install` to additionally create the `iplib-1.0-SNAPSHOT-javadoc.jar`

## License

Copyright 2021 Little Dog Digital

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.

You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
