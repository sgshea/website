(ns website.home
  (:require
   [reagent.core :as r]
   [reagent-mui.material.typography :refer [typography]]
   [reagent-mui.material.box :refer [box]]
   [reagent-mui.material.container :refer [container]]
   [reagent-mui.material.stack :refer [stack]]
   [reagent-mui.material.card :refer [card]]
   [reagent-mui.material.card-content :refer [card-content]]
   [reagent-mui.material.app-bar :refer [app-bar]]
   [reagent-mui.material.toolbar :refer [toolbar]]))

(defn menu-bar
  "Top bar for the pages"
  []
  [app-bar {:position "static"}
   [container {:maxwidth "x1"}
     [typography {:variant :h6} "Sammy Shea"]]])

(defn main
  []
  [menu-bar])

