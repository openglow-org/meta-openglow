# python3-gfhardware pin. Bump deliberately (AUTOREV is not reproducible);
# keep only the pin here - the ForgeFIRM image manifest leaves *-pin.inc
# out of the layer content hash because the component entry already
# identifies the pinned source. The forgefirm-app recipes in meta-forgefirm
# pin the same repository; move both together.
SRCREV = "0f59c547b6e8418712ab9e000c58eb1975c29d79"
