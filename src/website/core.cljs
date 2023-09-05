(ns website.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [website.about :as wabout]))

;; -------------------------
;; Initialize website
(defn home-page []
  [wabout/main])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
