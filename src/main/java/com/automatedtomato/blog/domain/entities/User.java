package com.automatedtomato.blog.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    // CascadeType.ALLを指定することで、Postはauthorを変更不可だが、
    // authorはPostを変更可能。authorが削除されると、Postも削除される
    private List<Post> posts = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(createdAt, user.createdAt);
    }
    
    // このアノテーションにより、エンティティのライフサイクルが自動的に管理される
    // このメソッドの場合、新しいユーザーが生成されると、
    // JPAは自動的にこのメソッドを呼び出しタイムスタンプを押す
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
