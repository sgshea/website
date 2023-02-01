(ns website.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [reagent-mui.colors :as colors]
     [reagent-mui.styles :as styles]
     [reagent-mui.material.css-baseline :refer [css-baseline]]
     [website.home :as homepage]))

;; -------------------------
;; Views

;; Theme
(def custom-theme
  {:palette {:mode "dark"}})

(defn home-page []
  [:<>
   [css-baseline]
   [styles/theme-provider (styles/create-theme custom-theme)
    [homepage/main]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
