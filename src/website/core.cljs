(ns website.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]))


;; -------------------------
;; Initialize website
(defn home-page []
  [:p "Hi!"])


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
