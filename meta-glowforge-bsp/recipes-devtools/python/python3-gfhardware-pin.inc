# python3-gfhardware pin. Bump deliberately (AUTOREV is not reproducible);
# keep only the pin here - the ForgeFIRM image manifest leaves *-pin.inc
# out of the layer content hash because the component entry already
# identifies the pinned source. The forgefirm-app recipes in meta-forgefirm
# pin the same repository; move both together.
SRCREV = "81027ffc3617c092e0fa23005d599229ebe57d61"
