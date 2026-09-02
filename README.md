# OpenGlow Yocto Board Support Packages (BSP) for Glowforge
This repository contains the board support packages needed to build opensource firmware for Glowforge brand CNC lasers.  

Layers:

* `meta-glowforge-bsp`: machine `glowforge`: the factory NXP i.MX6 control board (kernel, device tree, U-Boot, board recipes).
* `meta-openglow-core`: distro-neutral recipes shared by the images built on it (Glowforge service utilities, base-files, networking).

Both target the Yocto `scarthgap` release and are consumed by the [ForgeFIRM](https://github.com/openglow-org/forgefirm) build.

* [Community Support](https://community.openglow.org)
* [ForgeFIRM Installable Firmware](https://github.com/openglow-org/forgefirm)  

This project is for experimental purposes only, and is not supported or endorsed by Glowforge.
