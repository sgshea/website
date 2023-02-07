(ns website.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [reagent-mui.colors :as colors]
     [reagent-mui.styles :as styles] 
     [reagent-mui.material.box :refer [box]]
     [website.home :as homepage]
     [website.about :as about]))

;; -------------------------
;; Views

;; Theme
(def custom-theme
  {:palette {:mode :light
             }})

(defn home-page []
  [:<>
   [styles/theme-provider (styles/create-theme custom-theme)
    [box {}
      [homepage/menu-bar]
      [about/about]
     [about/technologies]]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
