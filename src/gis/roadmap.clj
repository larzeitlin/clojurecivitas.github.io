^{:kindly/hide-code true
  :clay             {:title  "GIS roadmap"
                     :quarto {:author   :luke-zeitlin
                              :type     :post
                              :date     "2025-10-23"
                              :draft    true
                              :category :gis
                              :tags     [:gis]}}}

(ns gis.roadmap
  (:require [scicloj.kindly.v4.kind :as kind]))

;; # Roadmap for Clojure GIS
;; The plan is to present a cohesive story for GIS work in the Clojure ecosystem.
;; At present this document can serve as a location to add notes, todos and thoughts.
;; Some future version of it may serve as a landing page.
;; # Why Clojure?
;; Clojure is, in many ways, ideally suited for GIS work.
;; - A single language across the stack with access to the Java ecosystem, JS via ClojureScript and Python libraries using [libpython-clj](https://github.com/clj-python/libpython-clj).
;; - An excellent, interactive namespace-as-a-notebook using [Clay](https://github.com/scicloj/clay) which can break down the boundries between notebooks and production code.
;; - Exploratory data manipulation is well suited to Clojure's interactive, REPL-driven development style.
;; - Immutable-by-default, avoiding the pitfalls that can make GIS work (for example in Python) painful.

;; 

;; # Working with GIS data 
;; ## Image formats
;; ### Raster
;; #### Cloud Optimized GeoTIFF (COG)
;; ##### What is a COG?
;; **TIFF** is an extensible image file format. **GeoTIFFs** are TIFFs with geospatial metadata
;; such as coordinate reference / projection information, Geographic extent,
;; pixel resolution and so on.
;; **Cloud Optimized GeoTIFFs (COGs)** are geoTIFFs arranged for efficient access over HTTP. This
;; is achieved with tiled layouts allowing for partial access (using HTTP range requests),
;; and resolution pyramids. This allows for fetching only the portion of the COG required.
;;
;; More details on the format at: [cogeo.org](https://www.cogeo.org)
;;
;; #### How to interact with COGs with Clojure
;; Many libraries for creation and manipulation of GeoTIFF data in other languages rely on
;; the [GDAL binary](https://gdal.org). 
;; This is performant and battle-tested but has a large footprint and is vulnerable to
;; version mismatches between the client language and GDAL.
;;
;; Some pure language implementations (that do not depend on GDAL) exist, such as
;; [geotiff.js](https://geotiffjs.github.io/) for JavaScript.
;; For the sake of
;; simplicity we recommend using interop with pure language GeoTIFF library where possible.
;;
;; [Working with GeoTIFFs on the JVM]("/gis/geotiff.html")
;;
;; ##### TODOs:
;; - geotiff.js / JavaScript interop example 
;; - Example of a containerized Python bindings with GDAL setup.
;;
;; 
;; #### NetCDF
;; NetCDF is a format for metadata enhanced, compressed, multidimensional arrays.
;; Often used for weather, climate, remote sensing and
;; oceanographic data.
;; Both [GeoTools](https://geotools.org/) and [NetCDF-Java](https://docs.unidata.ucar.edu/netcdf-java) are acceptable ways to to handle and create
;; netCDF files in Java-hosted Clojure. In JS we can read NetCDF files with
;; [netcdfjs](https://github.com/cheminfo/netcdfjs)
;; ##### TODOs:
;; - GeoTools/Apache SIS interop example
;; - NetCDF-Java example
;; - Which one is best?
;; - [netcdfjs](https://github.com/cheminfo/netcdfjs) example (maybe interactive with scittle/react/clay)
;;
;; #### HDF
;; Another widely used multidimensional array format in the scientific GIS world.
;;
;; [HDF in clojure](https://scicloj.github.io/clojure-data-scrapbook/projects/data-formats/hdf/index.html)
;; #### Zarr
;; ##### TODO:
;; - review [Python Xarray docs](https://tutorial.xarray.dev/intermediate/intro-to-zarr.html)
;; - how to read in Clojure
;; 
;; ### Vector
;; #### GeoJSON
;; - json->edn
;; - spec validation for geoJSON
;; - review [FarmLogs/geojson](https://github.com/FarmLogs/geojson)
;; #### Shapefile
;; - [ovid](https://github.com/willcohen/ovid)
;; #### Notes:
;; Maybe [Factual/geo](https://github.com/Factual/geo) is good for some of this?
;;
;; ## Cloud Optimized
;; ### PMTiles
;; - Reading: Timeverse PMtiles (Java interop)
;; - Creation: CLI / Babashka?
;; ### Notes:
;; [The Cloud Native Geo guide](https://guide.cloudnativegeo.org/) may be a useful starting
;; pount for some of this.
;;
^:kindly/hide-code
(kind/image {:src "resources/cogeo-formats-table.png"
             :style {:width "30em"}})
;; *Image from https:/guide.cloudnativegeo.org* 
;;
;; ## Image processing
;; Routing / Network analysis
;; ### Some articles to review
;; - [GTFS](https://en.wikipedia.org/wiki/GTFS)
;; - [MATSim](https://github.com/matsim-org)
;;
;; ## Spatial DBs
;; - postGIS
;; - MBTiles / sqllite
;;
;; ## Spatial reference systems
;; ### Coordinate system conversions
;; - [Coordinate Systems article](https://mgimond.github.io/Spatial/chp09_0.html) maybe a good starting point for a Clojure oriented article on the same.

;; ### H3
;; - again, [Factual/geo](https://github.com/factual/geo) may be a good starting point.
;;
;; ## Map widgets
;; ### Leaflet
;; ### OpenLayers
;; [OpenLayers](https://openlayers.org/en/latest/examples/) is a free, open source javascript map widget with wide support for various common data formats including WMS, GeoTIFFs, GeoJSON, etc. It supports webGL layers.
;; - [Example using OpenLayers from ClojureScript]("/earth_observation/waterquality.html")
;; ### Kepler.gl
;;
;; ## Geo-coding / Addresses
;;
;; ## Remote sensing
;; Example notebook: [Remote sensing water - Civitas](https://clojurecivitas.github.io/earth_observation/waterquality.html)
;; ### Satellite imagery
;; - Sentinel2
;; - Planet
;; - Google Earth Engine
;; ## Tile Servers
;;
;; # Python integration (libpython-clj)
;; A lot of GIS work is done in Python. Creating documentation, tools, containers to
;; make it quick/easy/simple to interact with Python from Clojure
;; will make doing GIS work in Clojure more palatable.
;;
;; # Template Projects
;; Some [deps-new](https://github.com/seancorfield/deps-new) or similar templates for
;; getting started on GIS projects.
;;
;; # Existing articles for Clojure GIS
;; Perhaps we can link to, rework or use some existing work including:
;; - [Seattle Parks - Scicloj](https://scicloj.github.io/clojure-data-scrapbook/projects/geography/seattle-parks/index.html)
;; - [Chicago Bikes - Scicloj](https://scicloj.github.io/clojure-data-scrapbook/projects/geography/chicago-bikes/index.html)
;; - [Cesium - Civitas](https://clojurecivitas.github.io/cesium/geovis.html)
;; - [Clojure Maps Examples](https://github.com/joannecheng/clojure-map-examples)
^:kindly/hide-code
(comment
  ,
  (require '[scicloj.clay.v2.api :as clay])

  (clay/make! {:source-path "src/gis/roadmap.clj"
               :live-reload :toggle}))

