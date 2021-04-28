<?php

namespace App\Entity;

use App\Repository\CategorieRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=CategorieRepository::class)
 */
class Categorie
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $description;

    /**
     * @ORM\OneToMany(targetEntity=Produit::class, mappedBy="categorie")
     */
    private $productId;

    public function __construct()
    {
        $this->productId = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    /**
     * @return Collection|Produit[]
     */
    public function getProductId(): Collection
    {
        return $this->productId;
    }

    public function addProductId(Produit $productId): self
    {
        if (!$this->productId->contains($productId)) {
            $this->productId[] = $productId;
            $productId->setCategorie($this);
        }

        return $this;
    }

    public function removeProductId(Produit $productId): self
    {
        if ($this->productId->removeElement($productId)) {
            // set the owning side to null (unless already changed)
            if ($productId->getCategorie() === $this) {
                $productId->setCategorie(null);
            }
        }

        return $this;
    }
}
