---
title: 'Clojure Fullstack Application'
description: 'Clojure Fullstack Application.'
pubDate: 'Jun 10 2023'
heroImage: '/clj_fullstack.svg'
tags: ['clojure']
source: https://github.com/sgshea/ecommerce
---

Demo application created using a technology stack centered around [Clojure](https://clojure.org/) for both the back and frontend.

Features include a frontend using [ClojureScript](https://clojurescript.org/) and [Reagent](https://reagent-project.github.io/), and a backend API server with an SQLite database.

This project showcases a full-stack application built using Clojure for both the backend and frontend, using a very simplistic inventory/ecommerce scenario. The stack includes Clojure on the JVM for the backend, Ring for HTTP server abstraction, Integrant for system state management, Reitit for routing, SQLite with JDBC-based access via next.jdbc, and Buddy for authentication. 

On the frontend, it utilizes ClojureScript, compiled to JavaScript using Shadow-CLJS, along with Reagent (a React wrapper for ClojureScript) and MUI components.