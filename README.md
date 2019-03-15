# Ayte :: Utility :: Value

![CircleCI branch](https://img.shields.io/circleci/project/github/ayte-io/java-utility-value/master.svg?style=flat-square)
![Bintray](https://img.shields.io/bintray/v/ayte/maven/io.ayte.utility.value.svg?style=flat-square)
![SonarQube tech debt](https://img.shields.io/sonar/https/sonarcloud.io/io.ayte.utility:value/tech_debt.svg?style=flat-square)
![Scrutinizer code quality](https://img.shields.io/scrutinizer/g/ayte-io/java-utility-value.svg?style=flat-square)
![Code Climate issues](https://img.shields.io/codeclimate/issues/ayte-io/java-utility-value.svg?style=flat-square)

This project contains utility value classes that are commonly used 
(Pair, Trio, etc.) and helper classes with static methods to reduce
common boilerplate.

## Coordinates

Project comes in two packages: API (just interfaces) and kit (actual
implementations), Their coordinates are `io.ayte.utility.value:api` and
`io.ayte.utility.value:kit` respectively. 

As for now, artifacts are available only in 
[Bintray Ayte repository](https://bintray.com/beta/#/ayte/maven/io.ayte.utility.value).

## Usage

Project exposes basic `Pair` and `Trio` interfaces for two- and 
three-argument containers with basic getters, as well as `AmplePair` and 
`AmpleTrio`, which contain setters and extra transformation methods. Kit
exposes mutable and immutable interface implementations, with `Pairs` 
and `Trios` utility classes:

```java
AmpleTrio<Integer, Integer, Integer> alpha = Trios.immutable(1, 2, 3);
AmpleTrio<Integer, Double, Integer> beta = alpha.mapSecond(x -> 1.0 / x);
AmpleTrio<Integer, Double, Boolean> gamma = beta.withThird(true);
AmpleTrio<Boolean, Integer, Double> delta = gamma.rotate();
AmpleTrio<Double, Integer, Boolean> epsilon = delta.reverse();
```

The actual difference between mutable and immutable implementations is
only in `setX` methods, all other methods produce new instances.

## Licensing

MIT / UPL-1.0

Ayte Labs, 2019

Do anything you want to
