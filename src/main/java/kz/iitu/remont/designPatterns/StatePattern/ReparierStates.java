package kz.iitu.remont.designPatterns.StatePattern;

import kz.iitu.remont.entities.Reapirier;

public interface ReparierStates {
    void AvailableRep(Reapirier r);
    void NotAvailableRep(Reapirier r);
}
