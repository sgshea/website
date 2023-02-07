(ns website.home
  (:require
   [reagent.core :as r]
   [reagent-mui.material.typography :refer [typography]]
   [reagent-mui.material.box :refer [box]]
   [reagent-mui.material.container :refer [container]]
   [reagent-mui.material.app-bar :refer [app-bar]]
   [reagent-mui.material.toolbar :refer [toolbar]]
   [reagent-mui.material.button :refer [button]]
   [reagent-mui.icons.person :refer [person]]
   [reagent-mui.material.menu :refer [menu] :as menu-component]
   [reagent-mui.material.menu-item :refer [menu-item]]
   [reagent-mui.icons.menu :refer [menu] :rename {menu menu-icon}]
   [reagent-mui.material.icon-button :refer [icon-button]]))

(defn event-value
  [e]
  (.. e -target -value))

;; Below is the code for the app-bar
(def pages
  ["About" "Projects" "Resume"])

(defonce anchorElNav (r/atom nil))

(defn pages-item
  [page-name]
  [menu-item {:key page-name
              :on-click (fn [e]
                         (reset! anchorElNav (event-value e)))}
   [typography {:textAlign "center"}
    page-name]])

(defn pages-button
  [page-name]
  [button {:key page-name
           :on-click (fn [e]
                      (reset! anchorElNav (event-value e)))
           :sx {:my 2
                :color "text.secondary"
                :display "block"}}
   page-name])

(defn menu-bar
  "Top bar for the pages"
  []
  [app-bar {:enableColorOnDark true}
   [container {:maxWidth "x1"}
     [toolbar {:disableGutters true}
      [person {:sx {:display {:xs "none"
                              :md "flex"}
                    :mr 1}}]
      [typography {:variant :h5
                   :noWrap true
                   :component :a
                   :href "/"
                   :sx {:mr 2
                        :display {:xs "none"
                                  :md "flex"}
                        :fontFamily "monospace"
                        :fontWeight 700
                        :textDecoration "none"
                        :color "text.primary"}}
       "Sammy Shea"]
      [box {:sx {:flexGrow 1
                 :display {:md "none"}}}
       [icon-button {:size "large"
                     :aria-label ""
                     :aria-controls "menu-appbar"
                     :aria-haspopup true
                     :on-click (fn []
                                (reset! anchorElNav true))
                     :color "inherit"}
        [menu-icon]]
       [menu {:id "menu-appbar"
              :anchorEl anchorElNav
              :anchorOrigin {:vertical "bottom"
                             :horizontal "left"}
              :keepMounted true
              :transformOrigin {:vertical "top"
                                :horizontal "left"}
              :open (some? @anchorElNav)
              :onClose (fn []
                         (reset! anchorElNav nil))
              :sx {:display {:xs "block"
                             :md "none"}}} 
        (map pages-item pages)]]
      [typography {:variant :h5
                   :noWrap true
                   :component :a
                   :href "/"
                   :sx {:mr 2
                        :display {:xs "flex"
                                  :md "none"}
                        :fontFamily "monospace"
                        :fontWeight 700
                        :textDecoration "none"
                        :color "text.primary"}}
       "Sammy Shea"]
      [person {:sx {:display {:xs "flex"
                              :md "none"}
                    :mr 1}}]
      [box {:sx {:flexGrow 1
                 :display {:xs "none"
                           :md "flex"}}}
       (map pages-button pages)]]]])