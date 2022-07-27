(ns website.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [clojure.string :as str]
   [website.content :as content]))

;; -------------------------

;; State
(defonce app-state
  (atom {:text "Hello World!"}))

;; Main Page
(defn main-page []
  [:div
   [content/top-nav]
   [content/separator "overview"]
   [content/overview]
   [content/separator "projects"]
   [content/projects]])

;; System
(defn mount-root []
  (d/render [main-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))