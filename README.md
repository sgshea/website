# Sammy Shea's Website
### Development mode
```
npm install
npx shadow-cljs watch app
```
start a ClojureScript REPL
```
npx shadow-cljs browser-repl
```
Watch for Sass scss changes
```
sass --watch --no-source-map src/mystyles.scss:public/css/mystyles.css
```
### Building for production
```
npx shadow-cljs release app
sass --no-source-map src/mystyles.scss:public/css/mystyles.css
```