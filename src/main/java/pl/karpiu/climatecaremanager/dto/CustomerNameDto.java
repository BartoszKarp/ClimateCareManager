package pl.karpiu.climatecaremanager.dto;

import java.util.UUID;

public record CustomerNameDto(UUID id, String firstName, String lastName) {
}
