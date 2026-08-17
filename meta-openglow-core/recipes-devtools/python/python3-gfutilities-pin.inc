# python3-gfutilities pin. Bump deliberately, like the other project repos;
# keep only SRCREV and PV here - the ForgeFIRM image manifest leaves
# *-pin.inc out of the layer content hash because the component entry
# already identifies the pinned source.
SRCREV = "b86ef35218c4d0c4729a8ec64eb57f9c4e0a4e1a"

# Bump PV with every SRCREV move so the git-hash-derived package version
# stays monotonic (a lower short hash would otherwise trip the
# version-going-backwards QA against the previous pin).
PV = "0.9.8+git"
