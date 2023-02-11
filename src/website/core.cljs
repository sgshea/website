(ns website.core
    (:require
     [reagent.dom :as d]
     [reagent-mui.colors :as colors]
     [reagent-mui.styles :as styles] 
     [reagent-mui.material.css-baseline :refer [css-baseline]] 
     [reagent-mui.material.grid :refer [grid]]
     [website.home :as homepage]
     [website.about :as about]
     [website.projects :as projects]))

;; -------------------------
;; Views

;; Theme
(def custom-theme {:palette {:primary colors/blue 
                             :secondary colors/red}})

(defn home-page []
  [:box {}
    [:<>
    [css-baseline]
    [styles/theme-provider (styles/create-theme custom-theme)
     [grid {:container true
            :justify-content "center"}
      [about/about]
      [about/technologies]
      ]
     [homepage/menu-bar]
     [projects/projects]]]])


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
