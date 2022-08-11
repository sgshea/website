(ns website.core
  (:require
   ;[reagent.core :as r]
   [reagent.dom :as d]
   [website.content :as content]))

;; -------------------------

;; State
(defonce app-state
  (atom {:text "Hello World!"}))

;; Main Page
(defn main-page []
  [:div {:class "container"}
   [content/top-nav]
   [content/separator "overview"]
   [content/overview]
   [content/separator "website-project"]
   [content/website-project]
   [content/separator "tic-tac-toe-project"]
   [content/tic-tac-toe-project]
   [content/separator "class-216"]
   [content/class-216]
   [content/separator "class-217"]
   [content/class-217]])

;; System
(defn mount-root []
  (d/render [main-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))