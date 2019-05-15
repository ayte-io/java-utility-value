# Ayte :: Utility :: Value

[![CircleCI](https://img.shields.io/circleci/project/github/ayte-io/java-utility-value.svg?style=flat-square)](https://circleci.com/gh/ayte-io/java-utility-value)
[![Maven Central](https://img.shields.io/maven-central/v/io.ayte.utility.value/parent.svg?style=flat-square)](https://mvnrepository.com/artifact/io.ayte.utility.value)
[![Code Climate maintainability](https://img.shields.io/codeclimate/maintainability/ayte-io/java-utility-value.svg?style=flat-square)](https://codeclimate.com/github/ayte-io/java-utility-value)
[![Sonar Tech Debt](https://img.shields.io/sonar/https/sonarcloud.io/io.ayte.utility.value:parent/tech_debt.svg?style=flat-square)](https://sonarcloud.io/dashboard?id=io.ayte.utility.value%3Aparent)

[![MIT License](https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square)](LICENSE-MIT)
[![UPL-1.0 License](https://img.shields.io/badge/license-UPL&dash;1.0-brightgreen.svg?style=flat-square)](LICENSE-UPL-1.0)

This project contains utility value classes that are commonly used 
(Pair, Trio, etc.) and helper classes with static methods to reduce
common boilerplate.

See [utility](https://github.com/ayte-io/java-utility) project for 
better understanding.

## Coordinates

Project comes in two packages: API (just interfaces) and kit (actual
implementations), Their coordinates are 
[`io.ayte.utility.value:api`](https://mvnrepository.com/artifact/io.ayte.utility.value/api) 
and
[`io.ayte.utility.value:kit`](https://mvnrepository.com/artifact/io.ayte.utility.value/kit) 
respectively. 

Project is both java 8 compatible and exposes 
`io.ayte.utility.value.api` and `io.ayte.utility.value.kit` modules.

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
AmpleTrio<Boolean, Integer, Double> delta = gamma.rollForward();
AmpleTrio<Double, Integer, Boolean> epsilon = delta.reverse();
```

The actual difference between mutable and immutable implementations is
only in `setX` methods, all other methods produce new instances.

## Licensing

MIT / UPL-1.0

Ayte Labs, 2019

Do anything you want to
