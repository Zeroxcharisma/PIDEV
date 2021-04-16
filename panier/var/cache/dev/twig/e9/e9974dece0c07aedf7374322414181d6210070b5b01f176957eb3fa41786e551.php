<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* panier_front/index.html.twig */
class __TwigTemplate_82560880ce3cec9b7a41eafaf922eb381326b3d77e1b7863efa4393fe321c36b extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'body' => [$this, 'block_body'],
            'content' => [$this, 'block_content'],
        ];
    }

    protected function doGetParent(array $context)
    {
        // line 1
        return "baseFront.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "panier_front/index.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "panier_front/index.html.twig"));

        $this->parent = $this->loadTemplate("baseFront.html.twig", "panier_front/index.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 3
    public function block_title($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        echo "Panier index";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 5
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 6
        $this->displayBlock('content', $context, $blocks);
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function block_content($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "content"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "content"));

        // line 7
        echo "    <h1>Panier index</h1>
    <form action=\"#\" class=\"icons-tab-steps checkout-tab-steps wizard-circle\">
                    <!-- Checkout Place order starts -->
                    <h6><i class=\"step-icon step feather icon-shopping-cart\"></i>Cart</h6>
                    <fieldset class=\"checkout-step-1 px-0\">
                        <section id=\"place-order\" class=\"list-view product-checkout\">
                            <div class=\"checkout-items\">

                            <!-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
                             ";
        // line 16
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["paniers"]) || array_key_exists("paniers", $context) ? $context["paniers"] : (function () { throw new RuntimeError('Variable "paniers" does not exist.', 16, $this->source); })()));
        $context['loop'] = [
          'parent' => $context['_parent'],
          'index0' => 0,
          'index'  => 1,
          'first'  => true,
        ];
        if (is_array($context['_seq']) || (is_object($context['_seq']) && $context['_seq'] instanceof \Countable)) {
            $length = count($context['_seq']);
            $context['loop']['revindex0'] = $length - 1;
            $context['loop']['revindex'] = $length;
            $context['loop']['length'] = $length;
            $context['loop']['last'] = 1 === $length;
        }
        foreach ($context['_seq'] as $context["_key"] => $context["panier"]) {
            // line 17
            echo "                                <div class=\"card ecommerce-card\">
                                    <div class=\"card-content\">
                                        <div class=\"item-img text-center\">
                                            <a href=\"app-ecommerce-details.html\">
                                                <img src=\"../../../app-assets/images/pages/eCommerce/9.png\" alt=\"img-placeholder\">
                                            </a>
                                        </div>
                                        <div class=\"card-body\">
                                            <div class=\"item-name\">
                                            <h4>";
            // line 26
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["panier"], "nom", [], "any", false, false, false, 26), "html", null, true);
            echo "</h4>
                                                <span></span>
                                                <p class=\"item-company\">By <span class=\"company-name\">Amazon</span></p>
                                                <p class=\"stock-status-in\">In Stock</p>
                                            </div>
                                            <div class=\"item-quantity\">
                                                <p class=\"quantity-title\">Quantity :  ";
            // line 32
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["panier"], "qte", [], "any", false, false, false, 32), "html", null, true);
            echo "</p>
                                               
                                            </div>
                                            <br>
                                            <div class=\"item-quantity\">
                                                <p class=\"quantity-title\">Total :  ";
            // line 37
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["panier"], "total", [], "any", false, false, false, 37), "html", null, true);
            echo "</p>
                                               
                                            </div>
                                            <p class=\"delivery-date\">Delivery by, Wed Apr 25</p>
                                            <p class=\"offers\">17% off 4 offers Available</p>
                                        </div>
                                        <div class=\"item-options text-center\">
                                            <div class=\"item-wrapper\">
                                                <div class=\"item-rating\">
                                                    <div class=\"badge badge-primary badge-md\">
                                                        4 <i class=\"feather icon-star ml-25\"></i>
                                                    </div>
                                                </div>
                                                <div class=\"item-cost\">
                                                    <h6 class=\"item-price\">
                                                        \$";
            // line 52
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["panier"], "prix", [], "any", false, false, false, 52), "html", null, true);
            echo "
                                                    </h6>
                                                    <p class=\"shipping\">
                                                        <i class=\"feather icon-shopping-cart\"></i> Free Shipping
                                                    </p>
                                                </div>
                                            </div>
                                            <div class=\"wishlist remove-wishlist\">
                                                <i class=\"feather icon-x align-middle\"></i>  ";
            // line 60
            echo twig_include($this->env, $context, "panier_front/_delete_form.html.twig");
            echo "
                                            </div>
                                            
                                           
                                            <div class=\"cart remove-wishlist\">
                                                <i class=\"fa fa-heart-o mr-25\"></i> Wishlist
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                   <!-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
                               ";
            ++$context['loop']['index0'];
            ++$context['loop']['index'];
            $context['loop']['first'] = false;
            if (isset($context['loop']['length'])) {
                --$context['loop']['revindex0'];
                --$context['loop']['revindex'];
                $context['loop']['last'] = 0 === $context['loop']['revindex0'];
            }
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['panier'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 73
        echo "                            </div>
                            <div class=\"checkout-options\">
                                <div class=\"card\">
                                    <div class=\"card-content\">
                                        <div class=\"card-body\">
                                            <p class=\"options-title\">Options</p>
                                            <div class=\"coupons\">
                                                <div class=\"coupons-title\">
                                                    <p>Coupons</p>
                                                </div>
                                                <div class=\"apply-coupon\">
                                                    <p>Apply</p>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class=\"price-details\">
                                                <p>Price Details</p>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Total MRP
                                                </div>
                                                <div class=\"detail-amt\">
                                                    \$598
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Bag Discount
                                                </div>
                                                <div class=\"detail-amt discount-amt\">
                                                    -25\$
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Estimated Tax
                                                </div>
                                                <div class=\"detail-amt\">
                                                    \$1.3
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    EMI Eligibility
                                                </div>
                                                <div class=\"detail-amt emi-details\">
                                                    Details
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Delivery Charges
                                                </div>
                                                <div class=\"detail-amt discount-amt\">
                                                    Free
                                                </div>
                                            </div>
                                            <hr>
                                            <div class=\"detail\">
                                                <div class=\"detail-title detail-total\">Total</div>
                                                <div class=\"detail-amt total-amt\">\$574</div>
                                            </div>
                                            <div class=\"btn btn-primary btn-block place-order\">PLACE ORDER</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </fieldset>
                    <!-- Checkout Place order Ends -->

                   

                  
                </form>

    <a class=\"btn btn-outline-primary mr-1 mb-1 waves-effect waves-light\" href=\"";
        // line 150
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("panier_new");
        echo "\">Create new</a>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "panier_front/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  299 => 150,  220 => 73,  193 => 60,  182 => 52,  164 => 37,  156 => 32,  147 => 26,  136 => 17,  119 => 16,  108 => 7,  89 => 6,  79 => 5,  60 => 3,  37 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseFront.html.twig' %}

{% block title %}Panier index{% endblock %}

{% block body %}
{% block content %}
    <h1>Panier index</h1>
    <form action=\"#\" class=\"icons-tab-steps checkout-tab-steps wizard-circle\">
                    <!-- Checkout Place order starts -->
                    <h6><i class=\"step-icon step feather icon-shopping-cart\"></i>Cart</h6>
                    <fieldset class=\"checkout-step-1 px-0\">
                        <section id=\"place-order\" class=\"list-view product-checkout\">
                            <div class=\"checkout-items\">

                            <!-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
                             {% for panier in paniers %}
                                <div class=\"card ecommerce-card\">
                                    <div class=\"card-content\">
                                        <div class=\"item-img text-center\">
                                            <a href=\"app-ecommerce-details.html\">
                                                <img src=\"../../../app-assets/images/pages/eCommerce/9.png\" alt=\"img-placeholder\">
                                            </a>
                                        </div>
                                        <div class=\"card-body\">
                                            <div class=\"item-name\">
                                            <h4>{{ panier.nom }}</h4>
                                                <span></span>
                                                <p class=\"item-company\">By <span class=\"company-name\">Amazon</span></p>
                                                <p class=\"stock-status-in\">In Stock</p>
                                            </div>
                                            <div class=\"item-quantity\">
                                                <p class=\"quantity-title\">Quantity :  {{ panier.qte }}</p>
                                               
                                            </div>
                                            <br>
                                            <div class=\"item-quantity\">
                                                <p class=\"quantity-title\">Total :  {{ panier.total }}</p>
                                               
                                            </div>
                                            <p class=\"delivery-date\">Delivery by, Wed Apr 25</p>
                                            <p class=\"offers\">17% off 4 offers Available</p>
                                        </div>
                                        <div class=\"item-options text-center\">
                                            <div class=\"item-wrapper\">
                                                <div class=\"item-rating\">
                                                    <div class=\"badge badge-primary badge-md\">
                                                        4 <i class=\"feather icon-star ml-25\"></i>
                                                    </div>
                                                </div>
                                                <div class=\"item-cost\">
                                                    <h6 class=\"item-price\">
                                                        \${{ panier.prix }}
                                                    </h6>
                                                    <p class=\"shipping\">
                                                        <i class=\"feather icon-shopping-cart\"></i> Free Shipping
                                                    </p>
                                                </div>
                                            </div>
                                            <div class=\"wishlist remove-wishlist\">
                                                <i class=\"feather icon-x align-middle\"></i>  {{ include('panier_front/_delete_form.html.twig') }}
                                            </div>
                                            
                                           
                                            <div class=\"cart remove-wishlist\">
                                                <i class=\"fa fa-heart-o mr-25\"></i> Wishlist
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                   <!-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
                               {% endfor %}
                            </div>
                            <div class=\"checkout-options\">
                                <div class=\"card\">
                                    <div class=\"card-content\">
                                        <div class=\"card-body\">
                                            <p class=\"options-title\">Options</p>
                                            <div class=\"coupons\">
                                                <div class=\"coupons-title\">
                                                    <p>Coupons</p>
                                                </div>
                                                <div class=\"apply-coupon\">
                                                    <p>Apply</p>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class=\"price-details\">
                                                <p>Price Details</p>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Total MRP
                                                </div>
                                                <div class=\"detail-amt\">
                                                    \$598
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Bag Discount
                                                </div>
                                                <div class=\"detail-amt discount-amt\">
                                                    -25\$
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Estimated Tax
                                                </div>
                                                <div class=\"detail-amt\">
                                                    \$1.3
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    EMI Eligibility
                                                </div>
                                                <div class=\"detail-amt emi-details\">
                                                    Details
                                                </div>
                                            </div>
                                            <div class=\"detail\">
                                                <div class=\"detail-title\">
                                                    Delivery Charges
                                                </div>
                                                <div class=\"detail-amt discount-amt\">
                                                    Free
                                                </div>
                                            </div>
                                            <hr>
                                            <div class=\"detail\">
                                                <div class=\"detail-title detail-total\">Total</div>
                                                <div class=\"detail-amt total-amt\">\$574</div>
                                            </div>
                                            <div class=\"btn btn-primary btn-block place-order\">PLACE ORDER</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </fieldset>
                    <!-- Checkout Place order Ends -->

                   

                  
                </form>

    <a class=\"btn btn-outline-primary mr-1 mb-1 waves-effect waves-light\" href=\"{{ path('panier_new') }}\">Create new</a>
{% endblock %}
{% endblock %}

", "panier_front/index.html.twig", "C:\\xampp\\htdocs\\panier\\templates\\panier_front\\index.html.twig");
    }
}
