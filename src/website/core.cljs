(ns website.core
    (:require
     [reagent.dom :as d]
     [reagent-mui.colors :as colors]
     [reagent-mui.styles :as styles] 
     [reagent-mui.material.css-baseline :refer [css-baseline]] 
     [reagent-mui.material.grid :refer [grid]]
     [reagent-mui.material.snackbar :refer [snackbar]]
     [reagent-mui.material.alert :refer [alert]]
     [website.home :as homepage]
     [website.about :as about]
     [website.projects :as projects]))

;; -------------------------
;; Views
(defn under-construction
  "Alert to indicate website is currently being updated"
  [status? date]
  (if status?
    [snackbar {:open true}
    [alert {:severity "warning"}
      (str "As of " date " I am currently doing a major overhaul/update of the website!")]]
    nil))

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
      [under-construction true "Feburary 2023"]
      [about/about]
      [projects/projects]
      [about/technologies]
      ]
     [homepage/menu-bar]
     ]]])


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
