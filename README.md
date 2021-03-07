# awscidr

A simple wrapper around `iplib` to retrieve a (potentially filtered) list of AWS CIDR blocks

## Usage

The tool has a simple command line interface:

```shell
$ java -jar target/awscidr-1.0-SNAPSHOT-shaded.jar --help
usage: AWSCidr
-6,--ipv6           use ipv6 ranges instead of ipv4
-?,--help           print this help message
-f,--fr <region>    filter by region
-g,--fs <service>   filter by service - required region as well
-r,--regions        list regions
-s,--services       list services (ignored if 'r' specified)
-v,--version        print version
```

Broadly speaking it has three modes. 

To return a list of regions:
```shell
$ java -jar target/awscidr-1.0-SNAPSHOT-shaded.jar -r                
GLOBAL
af-south-1
ap-east-1
ap-northeast-1
ap-northeast-2
ap-northeast-3
ap-south-1
ap-south-2
ap-southeast-1
ap-southeast-2
ap-southeast-3
ca-central-1
cn-north-1
cn-northwest-1
eu-central-1
eu-central-2
eu-north-1
eu-south-1
eu-south-2
eu-west-1
eu-west-2
eu-west-3
me-south-1
sa-east-1
us-east-1
us-east-2
us-gov-east-1
us-gov-west-1
us-west-1
us-west-2
```

or a list of services:

```shell
$ java -jar target/awscidr-1.0-SNAPSHOT-shaded.jar -s
AMAZON
AMAZON_APPFLOW
AMAZON_CONNECT
API_GATEWAY
CHIME_MEETINGS
CHIME_VOICECONNECTOR
CLOUD9
CLOUDFRONT
CODEBUILD
DYNAMODB
EC2
EC2_INSTANCE_CONNECT
GLOBALACCELERATOR
KINESIS_VIDEO_STREAMS
ROUTE53
ROUTE53_HEALTHCHECKS
ROUTE53_HEALTHCHECKS_PUBLISHING
S3
WORKSPACES_GATEWAYS
```

or to provide a filtered list of CIDR blocks in either IPV6 or IPV4 form:

```shell
$ java -jar target/awscidr-1.0-SNAPSHOT-shaded.jar -f eu-west-1 -g S3
3.5.64.0/21
3.5.72.0/23
52.218.0.0/17
52.92.40.0/21
54.231.128.0/19

% java -jar target/awscidr-1.0-SNAPSHOT-shaded.jar -f eu-west-1      
108.128.0.0/13
108.128.160.0/23
108.128.162.0/24
13.248.113.0/24
13.248.118.0/24
.
.
.

$ java -jar target/awscidr-1.0-SNAPSHOT-shaded.jar -f eu-west-1 -g S3 -6
2a05:d050:8000::/40
2a05:d070:8000::/40
2a05:d078:8000::/40
2a05:d079:8000::/40
2a05:d07a:8000::/40
```

## Prerequisites
This was built with Java 12.0.2 and Maven 3.6.3.

It is assumed that Maven is in your execution path.

## Test and Build

Build and test using Maven:

```
$ mvn clean package
.
.
.
[INFO] Attaching shaded artifact.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.690 s
[INFO] Finished at: 2021-03-07T12:40:22Z
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
